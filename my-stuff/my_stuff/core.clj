(ns my-stuff.core
  (:gen-class))

(import '[src.java.pastrami.Animal])

(defn brown-sugar []
  (new src.java.pastrami.Animal "a")
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (brown-sugar))

