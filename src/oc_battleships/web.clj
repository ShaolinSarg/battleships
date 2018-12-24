(ns oc-battleships.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]))

(defroutes app-routes
  (GET "/"          []      "flom tom woo"))

(def app
  (-> app-routes
      (wrap-defaults api-defaults)
      wrap-json-body))
