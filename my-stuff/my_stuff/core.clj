(ns my-stuff.core
  (:gen-class)
  (:import (javax.swing JFrame JPanel JLabel JButton JOptionPane)
           (java.awt GridBagLayout)
           (java.awt.event ActionListener)
           )
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

(defn say-hello []
  (JOptionPane/showMessageDialog
    nil
    "Pastrami OK"
    "YOLO YODO YODA Kenobi Vader"
    JOptionPane/INFORMATION_MESSAGE)
  )

(def act (proxy [ActionListener] []
           (actionPerformed [event] (say-hello))))

(defn show-window-2 []
  (let [f (JFrame. "YOLO"),
        p (JPanel. (GridBagLayout.))
        label (new JLabel "Pastrami")
        ok-button (new JButton "OK")
        cancel-button (new JButton "Cancel")
        ]
    (.setBounds f 300 300 300 300)
    (.setVisible f true)
    (.add p label)
    (.add p ok-button)

    (.addActionListener ok-button act)

    (.add p cancel-button)
    (.add f p)
    (.pack f)
    ))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (brown-sugar))
  (print "this is the end")
  (show-window-2)
  )

