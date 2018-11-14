(ns oc-battleships.coordinates-test
  (:require  [clojure.test :as t :refer [deftest testing is]]
             [oc-battleships.coordinates :as sut]))


(deftest coordinate-tests
  (testing "ship-coordinates"
    (testing "should return the list of coordinates for a ship"
      (is (= [[0 0] [1 0] [2 0]] (sut/ship-coordinates [0 0] 3 :vertical)))
      (is (= [[0 0] [0 1] [0 2]] (sut/ship-coordinates [0 0] 3 :horizontal))))))

