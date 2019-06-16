(ns sthenos.hercules.domain.exercise
  (:require [clojure.spec.alpha :as s]
            [sthenos.hercules.domain.validations :as domain.validations]))

(s/def :exercise/name #{:burpee
                        :burpee-jump
                        :sprawl
                        :squat})

(s/def :exercise/description
  (s/and string? (domain.validations/min-length? :exercise/description)))

(s/def :exercise/movement
  (s/keys :req [:exercise/name
                :exercise/description
                :exercise/type
                :exercise/difficulty
                :exercise/variants
                (or :exercise/reps :exercise/duration)]))

(def burpee-example-movement
  {:exercise/name        :burpee
   :exercise/description "Burpees"
   :exercise/reps        20
   :exercise/type        :total-body
   :exercise/difficulty  :intermediate
   :exercise/variants    {:beginner :sprawl
                          :advanced :burpee-jump}})
