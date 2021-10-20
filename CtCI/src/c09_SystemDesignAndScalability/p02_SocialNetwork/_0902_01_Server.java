package c09_SystemDesignAndScalability.p02_SocialNetwork;

import static java.lang.System.out;

import java.util.HashMap;

public class _0902_01_Server {
	HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
	HashMap<Integer, Integer> personToMachineMap = new HashMap<Integer, Integer>();

	public Machine getMachineWithId(int machineID) {
		return machines.get(machineID);
	}

	public int getMachineIDForUser(int personID) {
		Integer machineID = personToMachineMap.get(personID);
		return machineID == null ? -1 : machineID;
	}

	public _0902_01_Person getPersonWithID(int personID) {
		Integer machineID = personToMachineMap.get(personID);
		if (machineID == null)
			return null;
		Machine machine = getMachineWithId(machineID);
		if (machine == null)
			return null;
		return machine.getPersonWithID(personID);
	}
}
