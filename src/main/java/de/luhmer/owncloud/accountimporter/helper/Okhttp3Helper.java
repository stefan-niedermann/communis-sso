package de.luhmer.owncloud.accountimporter.helper;

import java.io.InputStream;

import de.luhmer.owncloud.accountimporter.aidl.NextcloudRequest;
import de.luhmer.owncloud.accountimporter.api.NextcloudAPI;
import okhttp3.ResponseBody;

/**
 *  Nextcloud SingleSignOn
 *
 *  @author David Luhmer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class Okhttp3Helper {

    public static ResponseBody getResponseBodyFromRequest(NextcloudAPI nextcloudAPI, NextcloudRequest request) {
        try {
            InputStream os = nextcloudAPI.performNetworkRequest(request);
            return ResponseBody.create(null, 0, new BufferedSourceSSO(os));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseBody.create(null, "");
    }

}