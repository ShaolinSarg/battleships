(ns oc-battleships.auth
  (:require [buddy.auth.backends :as backends]
            [buddy.auth.middleware :refer [wrap-authentication]]))

(def allowed-token (or (System/getenv "BATTLESHIP_TOKEN")
                       "123"))

(defn auth-function
  [_ token]
  (= allowed-token token))

(def backend (backends/token {:authfn auth-function}))

(def wrap-auth wrap-authentication)

(def authenticated? buddy.auth/authenticated?)
