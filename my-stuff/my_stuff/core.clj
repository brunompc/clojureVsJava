(ns my-stuff.core
  (:gen-class)
  (:import (javax.swing JFrame JPanel JLabel JButton JOptionPane)
           (java.awt GridBagLayout)
           (java.awt.event ActionListener)
           )
  )

(import '[src.java.pastrami.Animal])
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
    (println (str "" (.getRandomNumber obj)))
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

(defn aprovado [a]
  (.estaAprovado a))

(defn eTuga [a]
  (.equals (.getNacionalidade a) "Portuguesa"))

(defn conta-aprovados [alunos]
  (count (filter (fn [a] (.estaAprovado a)) alunos)))

(defn conta-aprovados-portugueses [alunos]
  (count (filter (fn [a] (.equals (.getNacionalidade a) "Portuguesa")) (filter aprovado alunos))))

(defn get-nomes-aprovados [alunos]
  (map (fn [a] (.getNome a))
       (filter (fn [a] (.estaAprovado a)) alunos)))

(defn quantas-notas-diferentes [alunos]
  (count (distinct (map (fn [a] (.getNota a)) alunos))))

(defn media-notas-estrangeiras [alunos]
  (let [notas-estrangeiras (map (fn [a] (.getNota a))
                                (filter (fn [a] (not (.equals (.getNacionalidade a) "Portuguesa"))) alunos))]
    (/ (reduce + notas-estrangeiras)
       (count notas-estrangeiras))))

(defn nome-dois-alunos-melhor-nota [alunos]
  (sort-by (fn [a1 a2] (- (.getNota a1) (.getNota a2)))
           alunos))

(defn comparar-alunos [a1 a2]
  (compare (.getNota a1)
           (.getNota a2)))

;; does not work
;; because of subvec
(defn nome-dois-alunos-melhor-nota [alunos]
  (let* [alunos-ordenados (reverse (sort comparar-alunos alunos))
         dois-melhores (subvec alunos-ordenados 0 2)]
    (map (fn [a] (.getNome a) dois-melhores))))

;; hack-of-death #1
(defn nome-dois-alunos-melhor-nota [alunos]
  (let [alunos-ordenados (reverse (sort comparar-alunos alunos))]
    [(.getNome (first alunos-ordenados))
     (.getNome (first (rest alunos-ordenados)))]))

(defn nome-dois-alunos-melhor-nota [alunos]
  (let [alunos-ordenados (reverse (sort comparar-alunos alunos))]
    (map (fn [a] (.getNome a)) (take 2 alunos-ordenados))))

(defn nome-dois-alunos-melhor-nota [alunos]
  (let [alunos-ordenados (reverse (sort comparar-alunos alunos))]
    (map #(.getNome %1) (take 2 alunos-ordenados))))

;; hack-of-death #2
(defn dados-alunos-nota-mais-alta-crescente [alunos]
  (let* [alunos-ordenados-desc (reverse (sort comparar-alunos alunos))
         alunos [(first alunos-ordenados-desc),
                 (second alunos-ordenados-desc),
                 (nth alunos-ordenados-desc 2)]]
    (map (fn [a] (str (.getNome a)
                      ":"
                      (.getNacionalidade a)
                      ":"
                      (.getNota a)))
         (reverse alunos))))

(defn dados-alunos-nota-mais-alta-crescente [alunos]
  (let* [alunos-ordenados-desc (reverse (sort comparar-alunos alunos))
         alunos (take 3 alunos-ordenados-desc)]
    (map (fn [a] (str (.getNome a)
                      ":"
                      (.getNacionalidade a)
                      ":"
                      (.getNota a)))
         (reverse alunos))))

(defn ficha-funcional-lp2 []
  (let [alunos [(new src.java.pastrami.Aluno "Goiaba" 20 "Portuguesa"),
                (new src.java.pastrami.Aluno "Kitty" 19 "Portuguesa"),
                (new src.java.pastrami.Aluno "Corto" 13 "Grega"),
                (new src.java.pastrami.Aluno "Ruby" 16 "Portuguesa"),
                (new src.java.pastrami.Aluno "Vicky Cristina" 9 "Espanhola"),
                (new src.java.pastrami.Aluno "Firfiriki" 13 "Gr")]]
    (println (str "Aprovados: " (conta-aprovados alunos)))
    (println (str "Aprovados Portugueses: " (conta-aprovados-portugueses alunos)))
    (println (str "Nomes Aprovados: " (print-str (get-nomes-aprovados alunos))))
    (println (str "Quantas notas diferentes: " (quantas-notas-diferentes alunos)))
    (println (str "Medias notas estrangeiras: " (media-notas-estrangeiras alunos)))
    (println (str "Medias notas estrangeiras: " (float (media-notas-estrangeiras alunos))))
    (println (str "Top 2 alunos (desc): ") (print-str (nome-dois-alunos-melhor-nota alunos)))
    (println (str "Top 3 (asc): " (print-str (dados-alunos-nota-mais-alta-crescente alunos))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (brown-sugar))
  (println "this is the end")
  ;;(new src.java.pastrami.Aluno "Yo" 1 "Oy")
  ;;(show-window-2)
  (ficha-funcional-lp2)
  (println (take 2 [:a :b :c] ))
  )

