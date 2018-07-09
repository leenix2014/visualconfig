package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "act_rewards", schema = "dsqp_activity", catalog = "")
public class ActRewardsEntity {
    private long id;
    private String name;
    private String reward;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "reward")
    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActRewardsEntity that = (ActRewardsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, reward);
    }
}
