(ns advent-of-code.core
  (:gen-class)
  (:require [clojure.java.io :as io]))

(def input (-> "day_1/input.txt" io/resource slurp))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello World!"))
