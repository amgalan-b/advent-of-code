(ns advent-of-code.day_2_test
  (:require [clojure.test :refer :all]
            [advent-of-code.day-2 :refer :all]))

(deftest step-test
  (testing "Step"
    (is (= [1 9 10 70 2 3 11 0 99 30 40 50]
           (step [1 9 10 3 2 3 11 0 99 30 40 50] 0)))
    (is (= [3500 9 10 70 2 3 11 0 99 30 40 50]
           (step [1 9 10 70 2 3 11 0 99 30 40 50] 4)))))

(deftest run-test
  (testing "Run"
    (is (= (run [1 0 0 0 99])
           [2 0 0 0 99]))
    (is (= (run [2 3 0 3 99])
           [2 3 0 6 99]))
    (is (= (run [2 4 4 5 99 0])
           [2 4 4 5 99 9801]))
    (is (= (run [1 1 1 4 99 5 6 0 99])
           [30 1 1 4 2 5 6 0 99]))))

(deftest opcode-add-test
  (testing "Opcode add"
    (is (= [1 4 5 6 5 7 12]
           (opcode-add [1 4 5 6 5 7 0] 0)))))
