(ns org.becube.xml-to-xpath
  (:gen-class))

;; This utility program converts an xml element to its corresponding
;; XPath expressions.

;; The main function is named xmlToXpath. It takes a filename as input
;; and delivers a list of xpath expressions as output. The output from
;; this function can be pretty-printed into either html or as a
;; newline separated list.

(use 'clojure.xml)

(defn getAttributes[path attrs-map ] 
  (let [keyl (keys attrs-map )]
    (map (fn[k] (str path "/@" (name k))) keyl)
  )
)



(defn recurse-xmltree [collected-path xml-content-fragment]
  (if (= clojure.lang.PersistentStructMap (type xml-content-fragment))
    (let [tag (xml-content-fragment :tag)
          attrs (:attrs xml-content-fragment)
          path (str collected-path "/" (name tag))
          attrs-paths (getAttributes collected-path attrs)]
      ;;(prn (str "recursing-xmltree --> " path ", curse on? : " (= clojure.lang.PersistentStructMap (type xml-content-fragment))))
      ;;(prn  path)
      (reduce conj attrs-paths(map (fn[x] (recurse-xmltree path x)) (:content xml-content-fragment)))
    )    
    collected-path
  )
)

(defn pp-lines [pathlist]
  (println (reduce str "" (interpose "\n" pathlist)))
)

(defn xmlToXPath [filename]
  (let [xml-content (clojure.xml/parse filename)
        tag (xml-content :tag)
        attrs (:attrs xml-content)
        path (str "/" (name tag))]
    ;; Start recursing here -->
    ;;(case (not (nil? attrs)) (getAttributes  path attrs))
    (flatten (reduce conj [] (map (fn[x] (recurse-xmltree path x)) (:content xml-content))))

    )
)

(defn test-1 []
  (let [filename "C:/i/xsdToXPath/Update_Workday_Account_EXAMPLEDATA.xml"]
    (xmlToXPath filename)
    ) 
)

(defn test-2 []
  (let [filename "C:/i/xsdToXPath/Maintain_Contact_Information_for_Person_EXAMPLE.xml"]
    (xmlToXPath filename)
  ) 
)

(defn test-3 []
  (let [filename "C:/i/xsdToXPath/Maintain_Contact_Information_for_Person_EXAMPLE.xml"]
    (pp-lines (xmlToXPath filename))
  ) 
)


(def a {:a 32 :b 64})
;;(map (fn [d] (str "@" (first (keys d)))) a)




(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (if (not (= 1 (count args)))
    (do 
      (println "Usage: java -jar <thisjarname> <filename.xml>")
      (println "Returns a list of xpaths representing the xml structure in the input file to the console."))
    (pp-lines (xmlToXPath (first args)))
    )
  )
