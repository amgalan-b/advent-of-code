(ns advent-of-code.day-1-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-1 :refer :all]))

(deftest required-fuel-test
  (testing "Required fuel"
    (is (= (required-fuel 12) 2))
    (is (= (required-fuel 14) 2))
    (is (= (required-fuel 1969) 654))
    (is (= (required-fuel 100756) 33583))))

(deftest total-required-fuel-test
  (testing "Total required fuel"
    (is (= (total-required-fuel 14) 2))
    (is (= (total-required-fuel 1969) 966))
    (is (= (total-required-fuel 100756) 50346))))
