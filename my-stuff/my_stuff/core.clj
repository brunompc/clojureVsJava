(ns my-stuff.core
  (:gen-class)
  (:import (javax.swing JFrame JLabel))
  )

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

(defn show-window []
  (let [f (JFrame. "YOLO"),
        label (new JLabel "Pastrami")]
    (.setBounds f 300 300 300 300)
    (.setVisible f true)
    (.add f label)
    ))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (brown-sugar))
  (print "this is the end")
  (show-window)
  )

