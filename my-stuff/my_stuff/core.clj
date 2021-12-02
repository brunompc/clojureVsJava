(ns my-stuff.core
  (:gen-class))

;(import '[src.java.pastrami.Animal])
;(import '[Animal])

(defn brown-sugar []
  (let [obj (new src.java.pastrami.Animal "asdrubal")]
    (println obj)
    (println (.toString obj))
    (println (.getName obj))
    (.talk obj)
    ;;*compile-path*
    ))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (brown-sugar))
  (print "this is the end")
  )

