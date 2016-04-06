(ns cssfun.start
  (:require
    #_[om.core :as om :include-macros true]
    [devcards.core :as devcards]
    [cljs.test :as t :refer [report] :include-macros true]
    [sablono.core :as sab :include-macros true])
  (:require-macros
    [devcards.core :as dc :refer [defcard deftest]]
    [cljs.test :refer [testing is]]))

(enable-console-print!)

(defcard basic-test
         (deftest Basic-devcards-testing "Some sample tests"
           (testing "Testing context name"
                    (is (= 2 (+ 1 1)) "One plus one is two."))))

(defn- make-hiccup-name
  "Construct a hiccup keyword name from the supplied classes & ids"
  [& fragments]
  (keyword (apply str fragments)))

(defcard keyword-test
         (deftest hiccup-tests "Testing custom hiccup generators"
                  (testing "Keyword generation"
                    (is (= (make-hiccup-name "h1" "#" "home" "." "test" ".home"
                                             :h1#home.test.home))))))