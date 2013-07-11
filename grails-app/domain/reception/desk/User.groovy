package reception.desk

class User {

	transient springSecurityService

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
    int refreshRate
    String room

	static constraints = {
		username blank: false, unique: true
		password blank: false
        room nullable: true
	}

	static mapping = {
		password column: 'passwd'
        refreshRate defaultValue: 120000
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}

    def isRoomEmpty() {
        if(getRoom() == null || getRoom() == "") {
            return true;
        }
        else {
            return false;
        }

        return true; //Shouldn't get here but if it does assume its not set
    }
}
