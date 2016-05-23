(ns baizen.continuations
  (:require [baizen.formats :refer [drop-slash drop-trailing-whitespace]]))

(defn- butlastv
  "butlast for Vectors"
  [v] (subvec v 0 (dec (count v))))

(defn- only-numbers? [s]
  (and (not (empty? s))
       (re-matches #"[0-9]*" s)))

(defn- combine-with-new-field [acc previous-line current-line]
  (conj (butlastv acc) (apply conj previous-line current-line)))

(defn- drop-empty-field-and-combine [acc previous-line current-line]
  (conj (butlastv acc) (apply conj
                              (butlastv previous-line)
                              (str (last previous-line) (last current-line))
                              (rest current-line))))

(defn- space-seperate-combining-field [acc previous-line current-line]
  (conj (butlastv acc) (apply conj
                              (butlastv previous-line)
                              (str (last previous-line) " " (last current-line))
                              (rest current-line))))

(defn combine-continuations
  "reducer which combines current 88 line with previous line or leaves the line intact"
  [acc columns]
  (if (= "88" (first columns))
    (let [previous-line (conj (butlastv (last acc)) (drop-slash (drop-trailing-whitespace (last (last acc)))))
          line (rest columns)]
      (cond
        (only-numbers? (last previous-line)) (combine-with-new-field acc previous-line line)
        (empty? (last previous-line)) (drop-empty-field-and-combine acc previous-line line)
        :else (space-seperate-combining-field acc previous-line line)))
    (conj acc columns)))

(defn preprocess
  "combines continuation records with previous line"
  [lines]
  (reduce combine-continuations [] lines))
