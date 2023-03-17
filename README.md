# Drone Delivery Service

A squad of drones is tasked with delivering packages for a major online retailer in a world where time and distance do not matter.
Each drone can carry a specific weight and can make multiple deliveries before returning to home base to pick up additional packages; however, the goal is to make the fewest number of trips, as each time the drone returns to home base, it is
extremely costly to refuel and reload the drone. The software shall accept input which will include: the name of each drone, the maximum weight it can carry, along with a series of locations and the total weight
needed to be delivered to that specific location. The software should highlight the most efficient deliveries for each drone to make on each trip.
Assume that time and distance to each location do not matter, and that the size of each package is irrelevant. It is also assumed that the cost to refuel and restock each
drone is a constant and does not vary between drones. The maximum number of drones in a squad is 100, and there is no maximum number of required deliveries.

Solution Provided

I started my approach trying to understand what would be the best strategy to minimize the necessary number of trips. From what I could understand, this problem seems to be a variation of a famous optimization problem known as Bin Packing. Bin Packing is an NP-Complete problem, which means that the solutions we know today require polynomial time.
I chose not to do a brute force approach. I ended up deciding to use a more simplified logic, where I simply start loading the highest capacity drones with the loads from each location in descending order. As long as the drone is not yet full, it continues to charge. When the drone is no longer able to carry the load from any location, we start loading the next drone and so on, until all the loads from all locations have been allocated to the drones.
