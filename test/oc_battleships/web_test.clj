(ns oc-battleships.web-test
  (:require [clojure.core :refer [with-redefs-fn]]
            [clojure.test :refer [are deftest testing]]
            [oc-battleships.web :as sut]
            [ring.mock.request :as mock]
            [ring.util.response :as req]))

(defn authenticated-request
  "Creates an authenticated request for the given url"
  [method url]
  (mock/header (mock/request method url)
               :Authorization
               "Token 123"))

(deftest app-routes-test
  (with-redefs-fn {#'oc-battleships.handler.registration-handler/register-player (fn [_] (req/created "someUrl"))}
    (testing "authenticated end points"
      (testing "should return the right response status"
        #(are [expected actual] (= expected (:status actual))
           201 (sut/app (authenticated-request :post "/api/1.0/players"))
           401 (sut/app (mock/request :post "/api/1.0/players"))

           200 (sut/app (authenticated-request :get "/api/1.0/players/23/shots"))

           404 (sut/app (mock/request :get "/not-here")))))))
