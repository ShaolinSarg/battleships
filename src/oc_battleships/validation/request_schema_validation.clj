(ns oc-battleships.validation.request-schema-validation
  (:require [clojure.java.io :as io]
            [scjsv.core :as v]))


(def registration-schema (slurp (io/resource "public/api/1.0/schemas/Registration.json")))

(def validate-registration (v/validator registration-schema))
