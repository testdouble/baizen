(ns baizen.core
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]
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
    (reduce #(conj %1 (dissect-line %2))
            []
            (csv/read-csv rdr))))
