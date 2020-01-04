(ns advent-of-code.day-1)

(defn required-fuel
  [mass]
  (-> mass
      (/ 3)
      (int)
      (- 2)))

(defn total-required-fuel
  [mass]
  (loop [mass mass total-fuel 0]
    (let [fuel (required-fuel mass)]
      (if (not (> fuel 0))
        total-fuel
        (recur fuel (+ total-fuel fuel))))))

(defn read-fuels
  [f]
  (-> "day_1/input.txt"
      (clojure.java.io/resource)
      (slurp)
      (clojure.string/split-lines)
      (as-> v (map read-string v))
      (as-> v (map f v))))

(defn fuel-requirements
  "Part 1"
  []
  (->> required-fuel
      (read-fuels)
      (reduce +)))

(defn total-fuel-requirements
  "Part 2"
  []
  (->> total-required-fuel
       (read-fuels)
       (reduce +)))
