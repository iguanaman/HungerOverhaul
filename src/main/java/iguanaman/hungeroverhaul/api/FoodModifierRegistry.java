package iguanaman.hungeroverhaul.api;

import java.util.Comparator;
import java.util.TreeSet;

public class FoodModifierRegistry
{
    private static final Comparator<IFoodValueModifier> foodModifierPriorityComparator = new Comparator<IFoodValueModifier>()
    {
        @Override
        public int compare(IFoodValueModifier first, IFoodValueModifier second)
        {
            return first.getPriority() - second.getPriority();
        }
    };

    private static final TreeSet<IDefaultFoodValueModifier> defaultFoodModifiers = new TreeSet<IDefaultFoodValueModifier>(foodModifierPriorityComparator);
    private static final TreeSet<IContextualFoodValueModifier> contextualFoodModifiers = new TreeSet<IContextualFoodValueModifier>(foodModifierPriorityComparator);

    public static void registerFoodValueModifier(IFoodValueModifier foodModifier)
    {
        if (foodModifier instanceof IDefaultFoodValueModifier)
            defaultFoodModifiers.add((IDefaultFoodValueModifier) foodModifier);
        if (foodModifier instanceof IContextualFoodValueModifier)
            contextualFoodModifiers.add((IContextualFoodValueModifier) foodModifier);
    }

    public static IDefaultFoodValueModifier[] getDefaultFoodModifiers()
    {
        return defaultFoodModifiers.toArray(new IDefaultFoodValueModifier[0]);
    }

    public static IContextualFoodValueModifier[] getContextualFoodModifiers()
    {
        return contextualFoodModifiers.toArray(new IContextualFoodValueModifier[0]);
    }
}
