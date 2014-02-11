(ns baizen.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [baizen.continuations :refer [preprocess]]
            [baizen.dissect :refer [dissect-line]]))

(defmulti parse
  "parse a BAI file into a Vector of Maps"
  class)

(defmethod parse
  java.lang.String
  [file-name]
  (parse (io/reader file-name)))

(defmethod parse
  java.io.Reader
  [reader]
  (with-open [rdr reader]
    (let [lines (csv/read-csv rdr)
          preprocessed (preprocess lines)]
      (reduce #(conj %1 (dissect-line %2))
              []
              preprocessed))))
