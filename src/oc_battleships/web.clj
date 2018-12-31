(ns oc-battleships.web
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [oc-battleships.auth :as auth :refer [authenticated?]]
            [ring.util.response :as resp]
            [ring.middleware.defaults :refer [api-defaults wrap-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]))

(def unauthenticated-response (resp/status (resp/response nil) 401))

(defn- home
  [req]
  (if (authenticated? req)
    "Coming sooner..."
    unauthenticated-response))

(defroutes app-routes
  (GET "/" [] home)
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (-> app-routes
      (wrap-defaults api-defaults)
      wrap-json-body
      (auth/wrap-auth auth/backend)))
