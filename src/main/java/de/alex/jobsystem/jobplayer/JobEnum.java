package de.alex.jobsystem.jobplayer;

public enum JobEnum {

    FISHERMAN("Fischer", 5),
    MINER("Minenarbeiter", 10),
    NOJOB("Kein Job", 0);


    private final String jobName;
    private final int coinsForATask;

    JobEnum(String jobName, int i) {
        this.coinsForATask = i;
        this.jobName = jobName;
    }

    public int getCoinsForATask() {
        return coinsForATask;
    }

    public String getJobName() {
        return jobName;
    }
}
