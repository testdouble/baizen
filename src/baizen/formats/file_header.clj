(ns baizen.formats.file-header)

(def fields [:record-name :sender-id :receiver-id
             :creation-date :creation-time :file-id
             :record-length :block-size :version])

(defn file-header
  "The file header marks the beginning of a file."
  [line]
  (let [line (assoc line
               0 "File Header"
               8 "2")]
    (zipmap fields line)))
