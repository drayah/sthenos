(ns sthenos.hercules.domain.validations)

(def min-lengths {:exercise/name 3})

(defn min-length? [attribute-name]
  #(>= (count %) (attribute-name min-lengths)))
