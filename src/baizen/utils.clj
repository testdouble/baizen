(ns baizen.utils
  (:require [clojure.string :as str]))

(defn drop-slash [s]
  (when s
    (str/replace s #"\/$" "")))

(defn drop-record-code [line] (subs line 3))
