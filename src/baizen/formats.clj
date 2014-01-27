(ns baizen.formats)

(defprotocol BaiFormat
  "a clojure protocol for describing a BAI record format"
  (fields [f])
  (index-of [f key])
  (prepare [f line])
  (dissect [f]))

(defrecord FileHeader [line]
  BaiFormat
  (fields [_]
    [:record-name :sender-id :receiver-id
     :creation-date :creation-time :file-id
     :record-length :block-size :version])

  (index-of [this key]
    (.indexOf (fields this) key))

  (prepare [this line]
    (assoc line
      (index-of this :record-name) "File Header"
      (index-of this :version) "2"))

  (dissect [this]
    (let [line (prepare this line)]
      (zipmap (fields this) line))))

(defn ?assoc [m k v]
  (assoc m k (or (get m k) v)))

(defrecord GroupHeader [line]
  BaiFormat
  (fields [_]
    [:record-name :receiver-id :originator-id
     :group-status :as-of-date :as-of-time
     :currency-code :as-of-date-modifier])

  (index-of [this key]
    (.indexOf (fields this) key))

  (prepare [this line]
    (-> line
        (assoc (index-of this :record-name) "Group Header")
        (?assoc (index-of this :currency-code) "USD")
        (assoc (index-of this :as-of-date-modifier) (str (first (get line (index-of this :as-of-date-modifier)))))))

  (dissect [this]
    (let [line (prepare this line)]
      (zipmap (fields this) line))))

(defrecord AccountIdentifier [line]
  BaiFormat
  (fields [_] [:record-name])

  (index-of [this key]
    (.indexOf (fields this) key))

  (prepare [this line]
    (-> line
        (assoc (index-of this :record-name) "Account Identifier and Summary Status")))

  (dissect [this]
    (let [line (prepare this line)]
      (zipmap (fields this) line))))
