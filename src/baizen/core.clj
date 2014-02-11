(ns baizen.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [baizen.dissect :refer [dissect-line]]
            [baizen.utils :refer [drop-slash drop-record-code]])
  (:import [java.io StringReader]))

(defn combine-continuations
  "reducer which combines current 88 line with previous line or leaves the line intact"
  [acc line]
  (if (.startsWith line "88")
    (let [prev-line (drop-slash (last acc))
          line (drop-record-code line)]
      (conj (butlast acc) (apply str prev-line "," line)))
    (conj acc line)))

(defn preprocess-reader
  "combines continuation records with previous line"
  [reader]
  (let [file-contents (slurp reader)
        lines (str/split-lines file-contents)]
    (StringReader. (apply str (interpose "\n" (reduce combine-continuations [] lines))))))

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
    (let [preprocessed-rdr (preprocess-reader rdr)]
      (reduce #(conj %1 (dissect-line %2))
              []
              (csv/read-csv preprocessed-rdr)))))
