(ns cssfun.start
  (:require
    #_[om.core :as om :include-macros true]
    [sablono.core :as sab :include-macros true])
  (:require-macros
    [devcards.core :as dc :refer [defcard deftest]]))

(enable-console-print!)

(defcard basic-test
         (sab/html [:h1 "Hello again, world."]))
