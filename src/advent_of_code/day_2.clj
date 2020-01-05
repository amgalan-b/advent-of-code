(ns advent-of-code.day-2)

(defn binary-operation
  [f]
  (fn [memory pointer]
    (let [x (memory (+ pointer 1))
          y (memory (+ pointer 2))
          z (memory (+ pointer 3))]
      (assoc memory z (f (memory x) (memory y))))))

(defn opcode-add
  [memory pointer]
  ((binary-operation +) memory pointer))

(defn opcode-multiply
  [memory pointer]
  ((binary-operation *) memory pointer))

(defn opcode-halt
  [_ _]
  nil)

(def opcode->operation
  {1 opcode-add
   2 opcode-multiply
   99 opcode-halt})

(defn step
  "Returns nil when the program is complete."
  [memory pointer]
  (let [operation (->> (memory pointer)
                       (opcode->operation))]
    (operation memory pointer)))

(defn run
  ([memory]
   (run memory 0))
  ([memory pointer]
   (let [mutated-memory (step memory pointer)]
     (if (nil? mutated-memory)
       memory
       (recur mutated-memory (+ pointer 4))))))

(defn read-memory
  []
  (-> "day_2.txt"
      (clojure.java.io/resource)
      (slurp)
      (clojure.string/split #",")
      (as-> v (map read-string v))
      (as-> seq (into [] seq))))

(defn first-value-after-run
  "Part 1"
  ([] first-value-after-run 12 2)
  ([noun verb]
   (-> (read-memory)
       (assoc 1 noun)
       (assoc 2 verb)
       (run)
       (first))))

(defn correct-result
  [m]
  (when (= (:output m) 19690720)
    (:result m)))

(defn find-noun-verb
  "Part 2"
  []
  (some correct-result
        (for [noun (range 100) verb (range 100)]
          {:result (+ verb (* 100 noun))
           :output (first-value-after-run noun verb)})))
