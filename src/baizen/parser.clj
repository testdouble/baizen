(ns baizen.parser
  (:require [clojure.core.match :refer [match]]
            [baizen.formats :refer :all]
            [baizen.formats.file-header :refer :all]
            [baizen.formats.group-header :refer :all]
            [baizen.formats.account-identifier :refer :all]
            [baizen.formats.s-transaction-detail :refer :all]
            [baizen.formats.transaction-detail :refer :all]
            [baizen.formats.account-trailer :refer :all]
            [baizen.formats.group-trailer :refer :all]
            [baizen.formats.file-trailer :refer :all])
  (:import [baizen.formats.file_header FileHeader]
           [baizen.formats.group_header GroupHeader]
           [baizen.formats.account_identifier AccountIdentifier]
           [baizen.formats.s_transaction_detail STransactionDetail]
           [baizen.formats.transaction_detail TransactionDetail]
           [baizen.formats.account_trailer AccountTrailer]
           [baizen.formats.group_trailer GroupTrailer]
           [baizen.formats.file_trailer FileTrailer]))

(defn parse-transaction [line]
  (match [line]
         [(["16" _ _ "S" & r] :seq)] (dissect (STransactionDetail. line))
         [(["16" & r] :seq)] (dissect (TransactionDetail. line))
         :else line))

(defn parse-header-trailer-section
  ([trailer-record-code lines record-group-parser]
   (parse-header-trailer-section trailer-record-code lines record-group-parser []))
  ([trailer-record-code lines record-group-parser acc]
   (if (nil? (first lines))
     acc
     (let [header-line (first lines)
           [content-lines [trailer-line & remaining-lines]]
            (split-with #(not (= (first %) trailer-record-code)) (rest lines))]
       (recur trailer-record-code
              remaining-lines
              record-group-parser
              (conj acc (record-group-parser header-line content-lines trailer-line)))))))

(defn parse-accounts [lines]
  (parse-header-trailer-section
    "49"
    lines
    (fn [header-line content-lines trailer-line]
      {:account-identifier (dissect (AccountIdentifier. header-line))
       :transactions (map parse-transaction content-lines)
       :account-trailer (dissect (AccountTrailer. trailer-line))})))

(defn- take-all-but-file-trailer [lines]
  (take-while #(not (= (first %) "99")) lines))

(defn parse-groups [lines]
  (let [file-lines (take-all-but-file-trailer lines)]
    (parse-header-trailer-section
     "98"
     file-lines
     (fn [header-line content-lines trailer-line]
       {:group-header (dissect (GroupHeader. header-line))
        :accounts (parse-accounts content-lines)
        :group-trailer (dissect (GroupTrailer. trailer-line))}))))

(defn parse-file-header [header-line]
  (dissect (FileHeader. header-line)))

(defn parse-file-trailer [trailer-line]
  (dissect (FileTrailer. trailer-line)))
