(ns oc-battleships.web
  (:require [compojure.core :refer [context defroutes GET POST]]
            [compojure.route :as route]
            [oc-battleships.auth :as auth :refer [authenticated?]]
            [oc-battleships.handler.registration-handler :refer [register-player]]
            [ring.middleware.defaults :refer [api-defaults wrap-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]
            [ring.util.response :as resp]
            [taoensso.timbre :as log]))

(def unauthenticated-response
  (-> (resp/response nil)
      (resp/status 401)))

(defn- secure-handler [handler req]
  (if (authenticated? req)
    (handler (:body req))
    unauthenticated-response))

(defn- handle-register-player []
  (partial secure-handler register-player))

(defroutes app-routes
  (context "/api/1.0" []
           (POST "/players" [] (handle-register-player))

           (context "/players/:id" [id]
                    (GET "/shots" [] (str "player " id " shots"))))

  (route/not-found "<h1>Page not found</h1>"))

(def app
  (-> app-routes
      (wrap-defaults api-defaults)
      (wrap-json-body {:keywords? true})
      (auth/wrap-auth auth/backend)))
