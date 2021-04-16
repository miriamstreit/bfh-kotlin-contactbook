package contactbook

class ContactBook (private var capacity: Int = 0) {
    val initialCapacity = capacity
    var contacts : Array<Contact?> = arrayOfNulls(capacity)

    fun getCapacity() : Int { return contacts.size}

    fun getSize() : Int {
        var counter = 0
        for (c in contacts) {
            if (c != null) counter++
        }
        return counter
    }

    fun addContact(contact: Contact) : Boolean {
        for (c in contacts) {
            if (c?.name.equals(contact.name)) return false;
        }
        if (capacity == getSize()) {
            capacity++
            contacts = createArrayFromSize(capacity, contacts)
        }
        contacts[getSize()] = contact
        return true
    }

    fun findContact(name: String): Contact? {
        for (c in contacts) {
            if (c?.name.equals(name)) return c
        }
        return null
    }

    fun removeContact(name: String): Boolean {
        for (i in contacts.indices) {
            if (contacts[i]?.name.equals(name)) {
                contacts[i] = null
                if (capacity > initialCapacity) capacity--
                contacts = createArrayFromSize(capacity, contacts)
                return true
            }
        }
        return false
    }

    private fun createArrayFromSize(size: Int, values: Array<Contact?>): Array<Contact?> {
        val newArray : Array<Contact?> = arrayOfNulls(size)
        var newArrayIndex = 0
        for (i in values.indices) {
            if (values[i] !== null) {
                newArray[newArrayIndex] = values[i]
                newArrayIndex++
            }
        }
        return newArray
    }
}