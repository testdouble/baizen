(ns baizen.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [baizen.dissect :refer [dissect-line]]
            [baizen.utils :refer [drop-slash drop-record-code vbutlast]])
  (:import [java.io StringReader]))

(defn combine-continuations
  "reducer which combines current 88 line with previous line or leaves the line intact"
  [acc columns]
  (if (= "88" (first columns))
    (let [prev-line (conj (vbutlast (last acc)) (drop-slash (last (last acc))))
          line (rest columns)]
      (conj (vbutlast acc) (apply conj prev-line line)))
    (conj acc columns)))

(defn preprocess
  "combines continuation records with previous line"
  [lines]
  (reduce combine-continuations [] lines))

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
