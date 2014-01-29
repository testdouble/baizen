(ns baizen.dissect
  (:require [clojure.core.match :refer [match]]
            [baizen.formats :refer :all]
            [baizen.formats.file-header :refer :all]
            [baizen.formats.group-header :refer :all]
            [baizen.formats.account-identifier :refer :all]
            [baizen.formats.transaction-detail :refer :all]
            [baizen.formats.account-trailer :refer :all])
  (:import [baizen.formats.file_header FileHeader]
           [baizen.formats.group_header GroupHeader]
           [baizen.formats.account_identifier AccountIdentifier]
           [baizen.formats.transaction_detail TransactionDetail]
           [baizen.formats.account_trailer AccountTrailer]))

(defn dissect-line
  "dissect a BAI vector into a hash of understandable parts"
  [line]
  (match [line]
         [(["01" & r] :seq)] (dissect (FileHeader. line))
         [(["02" & r] :seq)] (dissect (GroupHeader. line))
         [(["03" & r] :seq)] (dissect (AccountIdentifier. line))
         [(["16" & r] :seq)] (dissect (TransactionDetail. line))
         ;; [(["88" & r] :seq)] (dissect (ContinuationRecord. line))
         [(["49" & r] :seq)] (dissect (AccountTrailer. line))
         ;; [(["98" & r] :seq)] (dissect (GroupTrailer. line))
         ;; [(["99" & r] :seq)] (dissect (FileTrailer. line))
         :else line))
