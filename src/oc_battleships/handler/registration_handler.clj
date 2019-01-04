(ns oc-battleships.handler.registration-handler
  (:require [ring.util.response :as req]
            [oc-battleships.validation.request-schema-validation :as schema]
            [taoensso.timbre :as log]))

(defn register-player [registration]
  (log/info "Validating registration")
  (if-let [schema-errors (schema/validate-registration registration)]
    (req/status (req/response schema-errors) 400)
    (do
      (log/info "registration validation passed")
      (req/created "/api/1.0/players/23/shots"))))
