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
    (println (str "Nome antes: " (.getName obj)))
    (.setName obj "YOLO")
    ;;*compile-path*
    (println (str "Nome depois: " (.getName obj)))
    ))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (brown-sugar))
  (print "this is the end")
  )

