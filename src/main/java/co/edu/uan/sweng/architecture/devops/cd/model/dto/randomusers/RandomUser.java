
/*
 *     uan-spec-sweng-architecture-2-expo-01-devops-continuous-deployment-webapp
 *     Copyright (C) 2022  Garcia, J; Poveda, D; UAN
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package co.edu.uan.sweng.architecture.devops.cd.model.dto.randomusers;

import lombok.Data;

import java.util.List;
import javax.annotation.Generated;

/**
 * RandomUsers' POJO. It contains the information of all the users generated through the REST API.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
@Data
@Generated("jsonschema2pojo")
public class RandomUser {

    private List<Result> results;
    private Info info;
}
