/*
 * Copyright 2013 Jason Heithoff
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import reception.desk.User
import reception.desk.Role
import reception.desk.UserRole
import reception.desk.Person
import reception.desk.Student
import reception.desk.Stats
import reception.desk.Major
import reception.desk.Function

import org.codehaus.groovy.grails.plugins.springsecurity.SecurityFilterPosition
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

class BootStrap {
	def springSecurityService
	
    def init = { servletContext ->
        //SpringSecurityUtils.clientRegisterFilter('myAuthEventListener', SecurityFilterPosition.PRE_AUTH_FILTER.order + 10)

		//Stuff that can be run all the time
		def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
		def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

		def adminUser = User.findByUsername('admin') ?: new User(
			username: 'admin',
			//password: springSecurityService.encodePassword('admin'),
			password: 'admin',
			enabled: true).save(failOnError: true)

			if (!adminUser.authorities.contains(adminRole)) {
				UserRole.create adminUser, adminRole
			}

		log.info "Created user admin/admin."


        def user = User.findByUsername('tmcendar') ?: new User(username: 'tmcendar', password: 'tmcendar', enabled: true, room: 'Front Desk').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('tkung') ?: new User(username: 'tkung', password: 'tkung', enabled: true, room: '102A').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('mtperez') ?: new User(username: 'mtperez', password: 'mtperez', enabled: true, room: '102C').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('tsorgente') ?: new User(username: 'tsorgente', password: 'tsorgente', enabled: true, room: '102F').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('woodworth') ?: new User(username: 'woodworth', password: 'woodworth', enabled: true, room: '102F').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('lbullard') ?: new User(username: 'lbullard', password: 'lbullard', enabled: true, room: '102H').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('vpeterso') ?: new User(username: 'vpeterso', password: 'vpeterso', enabled: true, room: '102K').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('jlewis92') ?: new User(username: 'jlewis92', password: 'jlewis92', enabled: true, room: '102N').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('dmejia1') ?: new User(username: 'dmejia1', password: 'dmejia1', enabled: true, room: '102P').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('edmunds') ?: new User(username: 'edmunds', password: 'edmunds', enabled: true, room: '102Q').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('ctrepeck') ?: new User(username: 'ctrepeck', password: 'ctrepeck', enabled: true, room: 'Cubicle 1').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }
        user = User.findByUsername('tkung') ?: new User(username: 'mminan', password: 'mminan', enabled: true, room: 'Cubicle 2').save(failOnError: true)
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }




        log.info "Created user test/test."
		
		//Load functions
		Function.findByName('advising') ?: new Function(name: 'advising', description: 'Advising for semester classes').save(failOnError: true)
        Function.findByName('tutoring') ?: new Function(name: 'tutoring', description: 'Tutoring').save(failOnError: true)
        Function.findByName('preProf') ?: new Function(name: 'preProf', description: 'Advising for Pre-Professional Engineering').save(failOnError: true)
		Function.findByName('permNHolds') ?: new Function(name: 'permNHolds', description: 'Permission/Holds Removed').save(failOnError: true)
		Function.findByName('changeMajor') ?: new Function(name: 'changeMajor', description: 'Change of Major').save(failOnError: true)
		Function.findByName('graduation') ?: new Function(name: 'graduation', description: 'Graduation Applications/Issues').save(failOnError: true)
		Function.findByName('dl') ?: new Function(name: 'dl', description: 'Distance Learning').save(failOnError: true)
		Function.findByName('petitions') ?: new Function(name: 'petitions', description: 'Petitions').save(failOnError: true)
		Function.findByName('buildingTour') ?: new Function(name: 'buildingTour', description: 'Building Tour').save(failOnError: true)
		Function.findByName('questionCollege') ?: new Function(name: 'questionCollege', description: 'General Information on our College').save(failOnError: true)
		Function.findByName('scolarships') ?: new Function(name: 'scolarships', description: 'Scholarships').save(failOnError: true)
		Function.findByName('programs') ?: new Function(name: 'programs', description: 'Dual Enrollment/Summer Programs').save(failOnError: true)
		Function.findByName('other') ?: new Function(name: 'other', description: 'Other').save(failOnError: true)
		
		
		Major.findByDisplayName('Civil Engineering') ?: new Major(displayName: 'Civil Engineering', shortName: 'CIV', department: 'CEGE').save(failOnError: true)
        Major.findByDisplayName('Geomatics Engineering') ?: new Major(displayName: 'Geomatics Engineering', shortName: 'GEO', department: 'CEGE').save(failOnError: true)
        Major.findByDisplayName('Computer Science') ?: new Major(displayName: 'Computer Science', shortName: 'CS', department: 'CEECS').save(failOnError: true)
        Major.findByDisplayName('Computer Engineering') ?: new Major(displayName: 'Computer Engineering', shortName: 'CE', department: 'CEECS').save(failOnError: true)
        Major.findByDisplayName('Ocean Engineering') ?: new Major(displayName: 'Ocean Engineering', shortName: 'OC', department: 'OME').save(failOnError: true)
        Major.findByDisplayName('Mechanical Engineering') ?: new Major(displayName: 'Mechanical Engineering', shortName: 'ME', department: 'OME').save(failOnError: true)
        Major.findByDisplayName('Electrical Engineering') ?: new Major(displayName: 'Electrical Engineering', shortName: 'EE', department: 'CEECS').save(failOnError: true)
		
		//Init can only be called once
		Stats statInit = Stats.find { name == 'init' }
		if(statInit != null) {
			log.info "init has already executed. Nothing to do."
			return
		}
		
		def stat = new Stats(name: 'init', value: 1)
		stat.save()
		try {
			//Database Data
			//Check that Major table is empty
			log.info "Number of Majors: " + Major.count()
			if(Major.count() == 0) {
				def m = new Major(displayName: 'Civil Engineering', shortName: 'CIV', department: 'CEGE').save()
				m = new Major(displayName: 'Geomatics Engineering', shortName: 'GEO', department: 'CEGE').save()
			}
			
			//Test Data
			def p = new Person(student:new Student(cellNumber: '', cellProvider: ''), name: 'Test', email: 'test@test.com', zNumber: 'z12345678')
			p.save(flush:true, failOnError:true)
			
			p = new Person(student:null, name:'admin', email: 'admin@admin.com', zNumber:'z12345678')
			p.save(flush:true, failOnError:true)
			
			def person = Person.get(1)
			//println person.
			log.info "Count of Person Table: " + p
		} catch (Exception e) {
			e.printStackTrace();
			return
		}
    }
    def destroy = {
    }
}
