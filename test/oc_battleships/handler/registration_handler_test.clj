(ns oc-battleships.handler.registration-handler-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer [deftest is testing]]
            [oc-battleships.handler.registration-handler :as sut]
            [scjsv.core :as v]))


(def valid-registration {:name "clojure the destroyer"
                         :launchCode "rich"
                         :fleet {:carrier [["A" 1] ["A" 2] ["A" 3] ["A" 4] ["A" 5]]
                                 :battleship [["B" 0] ["B" 1] ["B" 2] ["B" 3]]
                                 :submarine [["C" 1] ["D" 1] ["E" 1]]
                                 :cruiser [["E" 1] ["F" 2] ["G" 3]]
                                 :Destroyer [["H" 1] ["G" 2]]}})


(def invalid-registration {:name "clojure the destroyer"})


(deftest register-player-test
  (testing "register-player"

    (testing "given a valid request body"
      (testing "should return the correct http status"
        (is (= 201
               (:status (sut/register-player valid-registration)))))
      (testing "should return a link in the header to the new resource"
        (is (= "/api/1.0/players/23/shots"
               (get-in (sut/register-player valid-registration) [:headers "Location"])))))

    (testing "given an invalid request body"
      (testing "should return the correct status"
        (is (= 400
               (:status (sut/register-player invalid-registration))))))))
