package com.example.springexample;

import com.example.springexample.models.Player;
import com.example.springexample.repositories.PlayerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class SpringExampleApplicationTests {


	private final PlayerRepository playerRepository = new PlayerRepository();

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("First JUnit Test: ")
	void firstTry() {
		assert true;
	}

	@Test
	void testRetrievePlayerById() {
		System.out.print("Testing retrievePlayerById: ");
		Player player = new Player("blacknoob33");
		UUID uuid = player.getUuid();
		playerRepository.savePlayer(player);

		Player retrievedPlayer = playerRepository.retrievePlayersById(uuid);
		assert retrievedPlayer != null;
		assert retrievedPlayer.getUuid().equals(uuid);
		assert retrievedPlayer.getName().equals("blacknoob33");
		assert retrievedPlayer.getAvatarUrl() == null;
		System.out.println("OK");

	}

	@Test
	void testSavePlayer() {
		System.out.print("Testing savePlayer: ");
		Player player = new Player("blacknoob33");
		UUID uuid = player.getUuid();

		UUID playerUUID = playerRepository.savePlayer(player);
		assert playerUUID.equals(uuid);
		assert playerRepository.retrievePlayersById(playerUUID) != null;
		System.out.println("OK");
	}

	@Test
	void testDeletePlayer() {
		System.out.print("Testing deletePlayer: ");
		Player player = new Player("blacknoob33");
		UUID uuid = player.getUuid();
		playerRepository.savePlayer(player);

		UUID playerUUID = playerRepository.deletePlayer(uuid);
		assert playerUUID.equals(uuid);
		assert playerRepository.retrievePlayersById(playerUUID) == null;
		System.out.println("OK");
	}
}
