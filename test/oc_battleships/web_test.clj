(ns oc-battleships.web-test
  (:require [oc-battleships.web :as sut]
            [clojure.test :refer [are deftest testing]]
            [ring.mock.request :as mock]))

(deftest app-routes-test
  (testing "end points"
    (testing "should return the right response status"
      (are [expected actual] (= expected (:status actual))
        200 (sut/app (mock/header (mock/request :get "/")
                                  :Authorization
                                  "Token 123"))

        401 (sut/app (mock/request :get "/"))

        404 (sut/app (mock/request :get "/not-here"))))))
