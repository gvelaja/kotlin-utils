enum class T(value: Int){
        A(100),
        B(200),
        C(300),
        D(400);
        var v = 0
        init {
            v = value
        }
        fun getValue(): Int{
            return v
        }

        companion object {
            fun setValue(value: Int): T?{
                for(v in values()){
                    if(v.getValue() == value) return v
                }
                return null
            }

            fun isValid(value: Int): Boolean{
                if(setValue(value) == null) return false
                return true
            }
        }
    }
