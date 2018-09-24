class CircularBuffer<T>(private val capacity: Int): Iterable<T> {
    private var mOffset = 0
    private val mBuffer = mutableListOf<T>()

    fun add(element: T) {
        if(mBuffer.count() < capacity) {
            mBuffer.add(element)
            mOffset = mBuffer.count() - 1
            return
        }
        mOffset++
        if(mOffset == capacity) mOffset = 0
        mBuffer[mOffset] = element
    }

    fun get(): T {
        return getTail()
    }

    fun getTail(): T {
        return mBuffer[mOffset]
    }

    fun getHead(): T {
        val offset = if(mBuffer.count() < capacity) 0 else (mOffset + 1) % capacity
        return mBuffer[offset]
    }

    fun clear() {
        mBuffer.clear()
        mOffset = 0
    }

    override fun iterator(): Iterator<T> {
        return mBuffer.iterator()
    }
}
