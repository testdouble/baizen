(ns baizen.utils
  (:require [clojure.string :as str]))

(defn drop-slash [s]
  (when s
    (str/replace s #"\/$" "")))

(defn drop-record-code [line] (subs line 3))

(defn vbutlast
  "butlast for Vectors"
  [v] (subvec v 0 (dec (count v))))
