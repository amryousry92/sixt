/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sixt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author Amr
 */
public class ScriptsOrder {

    /**
     *
     * @param allVulnerabilityScripts
     * @return
     */
    public static ArrayList<Integer> getRunOrder(ArrayList<VulnerabilityScript> allVulnerabilityScripts) {
        ArrayList<Integer> scriptsRunOrder = new ArrayList<>();
        boolean isAllDependenciesPresent;
        VulnerabilityScript script;
        int scriptIndex = 0;

        while (!allVulnerabilityScripts.isEmpty()) {
            scriptIndex %= allVulnerabilityScripts.size();
            script = allVulnerabilityScripts.get(scriptIndex);
            isAllDependenciesPresent = scriptsRunOrder.containsAll(script.getDependencies());
            if (isAllDependenciesPresent) {
                scriptsRunOrder.add(script.getScriptId());
                allVulnerabilityScripts.remove(scriptIndex);
            }
            scriptIndex++;
        }
        return scriptsRunOrder;
    }

    public static void main(String[] args) {
        VulnerabilityScript vs1 = new VulnerabilityScript(1, new ArrayList<>(Arrays.asList(2)));
        VulnerabilityScript vs2 = new VulnerabilityScript(2, new ArrayList<>(Arrays.asList()));
        VulnerabilityScript vs3 = new VulnerabilityScript(3, new ArrayList<>(Arrays.asList(1, 2)));
        ArrayList<VulnerabilityScript> scripts = new ArrayList<>(Arrays.asList(vs1, vs2, vs3));
        System.out.println(getRunOrder(scripts));
    }
}
