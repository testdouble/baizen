(ns baizen.continuations
  (:require [baizen.formats :refer [drop-slash drop-trailing-whitespace]]))

(defn- vbutlast
  "butlast for Vectors"
  [v] (subvec v 0 (dec (count v))))

(defn combine-continuations
  "reducer which combines current 88 line with previous line or leaves the line intact"
  [acc columns]
  (if (= "88" (first columns))
    (let [prev-line (conj (vbutlast (last acc)) (drop-slash (drop-trailing-whitespace (last (last acc)))))
          line (rest columns)]
      (if (empty? (last prev-line))
        (conj (vbutlast acc) (apply conj (vbutlast prev-line) line))
        (conj (vbutlast acc) (apply conj prev-line line))))
    (conj acc columns)))

(defn preprocess
  "combines continuation records with previous line"
  [lines]
  (reduce combine-continuations [] lines))
