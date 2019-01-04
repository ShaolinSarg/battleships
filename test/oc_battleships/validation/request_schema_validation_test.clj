(ns oc-battleships.validation.request-schema-validation-test
  (:require  [clojure.test :refer [deftest testing is]]))


(defn validate-registration-request [request]
  [])

(deftest registration-schema-validation-test
  (testing "a registration should pass validation"
    (is (empty? (validate-registration-request "")))))
