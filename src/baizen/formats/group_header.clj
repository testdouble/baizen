(ns baizen.formats.group-header)

(def
  ^{:private true}
  fields [:record-name :receiver-id :originator-id
          :group-status :as-of-date :as-of-time
          :currency-code :as-of-date-modifier])

(defn fields-index [key]
  (.indexOf fields key))

(defn- prepare [line]
  (-> line
      (assoc (fields-index :record-name) "Group Header")
      (assoc (fields-index :currency-code) (or (get line 6) "USD"))
      (assoc (fields-index :as-of-date-modifier) (str (first (get line (fields-index :as-of-date-modifier)))))))

(defn group-header
  "The file header marks the beginning of a file. It identifies the sender and the receiver of the transmission, and it describes the structure of the file. All fields are required except those labeled optional."
  [line]
  (let [line (prepare line)]
    (zipmap fields line)))
